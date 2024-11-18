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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.sf.jasperreports.jackson.type.NamedEnumConstantContextualDeserializer;
import net.sf.jasperreports.jackson.type.NamedEnumConstantSerializer;

/**
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 */
@JsonSerialize(using = NamedEnumConstantSerializer.class)
@JsonDeserialize(using = NamedEnumConstantContextualDeserializer.class)
@JsonInclude(Include.NON_EMPTY)
public interface NamedEnum
{

	String getName();
	
	default NamedEnum getDefault()
	{
		return null;
	}

}