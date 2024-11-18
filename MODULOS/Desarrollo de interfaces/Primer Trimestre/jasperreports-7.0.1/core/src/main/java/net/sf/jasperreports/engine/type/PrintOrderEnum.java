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
package net.sf.jasperreports.engine.type;


/**
 * @author Sanda Zaharia (shertage@users.sourceforge.net)
 */
public enum PrintOrderEnum implements NamedEnum
{
	/**
	 * Specifies that columns in a report should be filled vertically (fill an entire column and then go to the
	 * next one).
	 */
	VERTICAL("Vertical"),

	/**
	 * Specifies that columns in a report should be filled horizontally (columns are filled proportionally).
	 */
	HORIZONTAL("Horizontal");
	
	/**
	 *
	 */
	private final transient String name;

	private PrintOrderEnum(String name)
	{
		this.name = name;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	/**
	 *
	 */
	public static PrintOrderEnum getByName(String name)
	{
		return EnumUtil.getEnumByName(values(), name);
	}
	
	/**
	 *
	 */
	public static PrintOrderEnum getValueOrDefault(PrintOrderEnum value)
	{
		return value == null ? VERTICAL : value;
	}
	
	@Override
	public PrintOrderEnum getDefault()
	{
		return VERTICAL;
	}
}
