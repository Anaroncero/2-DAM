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

import java.awt.Color;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;

import net.sf.jasperreports.engine.util.JRColorUtil;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class ColorSerializer extends StdScalarSerializer<Color>
{
	private static final long serialVersionUID = 1L;

	public ColorSerializer()
	{
		this(null);
	}

	public ColorSerializer(Class<Color> vc)
	{
		super(vc);
	}

	@Override
	public void serialize(Color value, JsonGenerator jgen, SerializerProvider provider) throws IOException 
	{
		String strValue = convert(value);
		if (strValue != null)
		{
			jgen.writeString(strValue);
		}
	}

	public static String convert(Color value)
	{
		if (value == null)
		{
			return null;
		}
		return JRColorUtil.getCssColor(value);
	}
}
