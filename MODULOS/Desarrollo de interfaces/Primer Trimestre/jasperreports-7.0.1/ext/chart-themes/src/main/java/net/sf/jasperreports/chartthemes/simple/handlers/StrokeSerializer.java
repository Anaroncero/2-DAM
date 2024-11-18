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
package net.sf.jasperreports.chartthemes.simple.handlers;

import java.awt.BasicStroke;
import java.awt.Stroke;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class StrokeSerializer extends StdSerializer<Stroke>
{
	private static final long serialVersionUID = 1L;

	public StrokeSerializer()
	{
		this(null);
	}

	public StrokeSerializer(Class<Stroke> vc)
	{
		super(vc);
	}

	@Override
	public void serialize(Stroke value, JsonGenerator jgen, SerializerProvider provider) throws IOException 
	{
		if (jgen instanceof ToXmlGenerator)
		{
			((ToXmlGenerator)jgen).setNextIsAttribute(true);
		}
		jgen.writeStartObject();
		if (value instanceof BasicStroke)
		{
			jgen.writeNumberField("width", ((BasicStroke)value).getLineWidth());
		}
		jgen.writeEndObject();
	}
}
