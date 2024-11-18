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
package net.sf.jasperreports.components.items;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import net.sf.jasperreports.engine.JRCloneable;
import net.sf.jasperreports.engine.xml.JRXmlConstants;

/**
 * The Item interface. Provides a collection of item properties.
 * 
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
@JsonDeserialize(as = StandardItem.class)
public interface Item extends JRCloneable 
{

	/**
	 * Returns a list of {@link ItemProperty ItemProperty} objects. 
	 * Each item property provides a name-value pair.
	 * 
	 * @return a list of item properties
	 * @see ItemProperty
	 */
	@JacksonXmlProperty(localName = JRXmlConstants.ELEMENT_property)
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<ItemProperty> getProperties();

}
