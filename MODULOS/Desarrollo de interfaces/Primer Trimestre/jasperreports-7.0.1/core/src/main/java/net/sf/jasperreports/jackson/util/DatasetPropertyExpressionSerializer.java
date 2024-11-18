/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2023 Cloud Software Group, Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.jackson.util;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import net.sf.jasperreports.engine.DatasetPropertyExpression;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.type.ExpressionTypeEnum;
import net.sf.jasperreports.engine.xml.JRXmlConstants;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class DatasetPropertyExpressionSerializer extends StdSerializer<DatasetPropertyExpression>
{
	private static final long serialVersionUID = 1L;

	public DatasetPropertyExpressionSerializer()
	{
		this(null);
	}

	public DatasetPropertyExpressionSerializer(Class<DatasetPropertyExpression> vc)
	{
		super(vc);
	}

	@Override
	public void serialize(DatasetPropertyExpression value, JsonGenerator jgen, SerializerProvider provider) throws IOException 
	{
		ToXmlGenerator xgen = jgen instanceof ToXmlGenerator ? (ToXmlGenerator)jgen : null;

		if (xgen == null)
		{
			jgen.writeStartObject();
			jgen.writeStringField("name", value.getName());
			if (value.getEvaluationTime() != null)
			{
				jgen.writeStringField(JRXmlConstants.ATTRIBUTE_evaluationTime, value.getEvaluationTime().getName());
			}
			JRExpression expression = value.getValueExpression();
			if (expression != null)
			{
				if (expression.getType() == ExpressionTypeEnum.SIMPLE_TEXT)
				{
					jgen.writeStringField("type", ExpressionTypeEnum.SIMPLE_TEXT.getName());
				}
				jgen.writeStringField("text", expression.getText());
			}
			jgen.writeEndObject();
		}
		else
		{
			jgen.writeStartObject();
			xgen.setNextIsAttribute(true);
			jgen.writeStringField("name", value.getName());
			if (value.getEvaluationTime() != null)
			{
				xgen.setNextIsAttribute(true);
				jgen.writeStringField(JRXmlConstants.ATTRIBUTE_evaluationTime, value.getEvaluationTime().getName());
			}
			JRExpression expression = value.getValueExpression();
			if (expression != null)
			{
				if (expression.getType() == ExpressionTypeEnum.SIMPLE_TEXT)
				{
					xgen.setNextIsAttribute(true);
					jgen.writeStringField("type", ExpressionTypeEnum.SIMPLE_TEXT.getName());
				}
				xgen.setNextIsAttribute(false);
				try
				{
					xgen.getStaxWriter().writeCData(expression.getText());
				}
				catch (XMLStreamException e)
				{
					throw new IOException(e);
				}
			}
			jgen.writeEndObject();
		}
	}
}
