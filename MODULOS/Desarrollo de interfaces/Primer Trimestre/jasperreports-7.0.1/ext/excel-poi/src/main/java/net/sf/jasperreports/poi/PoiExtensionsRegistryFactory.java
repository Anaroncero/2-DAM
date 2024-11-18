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
package net.sf.jasperreports.poi;

import java.util.Collections;
import java.util.List;

import net.sf.jasperreports.components.iconlabel.IconLabelElement;
import net.sf.jasperreports.dataadapters.DataAdapterContributorFactory;
import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.export.GenericElementHandler;
import net.sf.jasperreports.engine.export.GenericElementHandlerBundle;
import net.sf.jasperreports.engine.query.JRQueryExecuterFactoryBundle;
import net.sf.jasperreports.engine.xml.JRXmlConstants;
import net.sf.jasperreports.extensions.ExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistryFactory;
import net.sf.jasperreports.poi.components.iconlabel.IconLabelElementXlsHandler;
import net.sf.jasperreports.poi.data.PoiDataAdapterServiceFactory;
import net.sf.jasperreports.poi.export.JRXlsExporter;
import net.sf.jasperreports.poi.query.PoiQueryExecuterFactoryBundle;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class PoiExtensionsRegistryFactory implements ExtensionsRegistryFactory
{
	private static final GenericElementHandlerBundle HANDLER_BUNDLE = 
		new GenericElementHandlerBundle()
		{
			@Override
			public String getNamespace()
			{
				return JRXmlConstants.JASPERREPORTS_NAMESPACE;
			}
			
			@Override
			public GenericElementHandler getHandler(String elementName,
					String exporterKey)
			{
				if (IconLabelElement.ELEMENT_NAME.equals(elementName))
				{
					if (JRXlsExporter.XLS_EXPORTER_KEY.equals(exporterKey))
					{
						return IconLabelElementXlsHandler.getInstance();
					}		
				}
				
				return null;
			}
		};

	private static final ExtensionsRegistry extensionsRegistry = 
		new ExtensionsRegistry()
		{
			@Override
			public <T> List<T> getExtensions(Class<T> extensionType) 
			{
				if (JRQueryExecuterFactoryBundle.class.equals(extensionType))
				{
					return (List<T>) Collections.singletonList((Object)PoiQueryExecuterFactoryBundle.getInstance());
				}
				if (DataAdapterContributorFactory.class.equals(extensionType))
				{
					return (List<T>) Collections.singletonList((Object)PoiDataAdapterServiceFactory.getInstance());
				}
				if (GenericElementHandlerBundle.class.equals(extensionType))
				{
					return (List<T>) Collections.singletonList((Object)HANDLER_BUNDLE);
				}
				return null;
			}
		};
	
	@Override
	public ExtensionsRegistry createRegistry(String registryId, JRPropertiesMap properties) 
	{
		return extensionsRegistry;
	}
}
