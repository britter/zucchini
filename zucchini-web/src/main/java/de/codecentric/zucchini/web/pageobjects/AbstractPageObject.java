/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.codecentric.zucchini.web.pageobjects;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPageObject implements PageObject {
	private WebDriver webDriver;

	@Override
	public void open() {
		String url = getUrl();
		if (url == null) {
			throw new IllegalPageObjectConfigurationException(String.format("%s.getUrl() must not return null.", this.getClass().getName()));
		}
		webDriver.get(url);
	}

	protected abstract String getUrl();

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{url=" + getUrl() + '}';
	}
}
