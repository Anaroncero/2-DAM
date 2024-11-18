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
package net.sf.jasperreports.engine.component;

import java.util.Optional;
import java.util.Set;

import net.sf.jasperreports.engine.JRRuntimeException;

/**
 * A component bundle is a package comprising of one or several components that
 * share the same XML namespace and schema. 
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 */
public interface ComponentsBundle
{

	/**
	 * Returns a set that contains the types of components included in this
	 * bundle.
	 * 
	 * @return the set of component types in this bundle
	 */
	Set<Class<? extends Component>> getComponentTypes();

	/**
	 * Returns the manager for a component.
	 * 
	 * @param componentType the component type
	 * @return the manager for the corresponding component type
	 * @throws JRRuntimeException if the bundle does not include a component type
	 * having the specified name
	 */
	Optional<ComponentManager> getComponentManager(Class<? extends Component> componentType);

}