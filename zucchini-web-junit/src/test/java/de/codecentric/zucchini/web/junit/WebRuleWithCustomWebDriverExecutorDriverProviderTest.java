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

package de.codecentric.zucchini.web.junit;

import de.codecentric.zucchini.web.WebDriverExecutor;
import de.codecentric.zucchini.web.provider.HtmlUnitDriverProvider;
import org.junit.Rule;

public class WebRuleWithCustomWebDriverExecutorDriverProviderTest extends ZucchiniWebRuleTestBase {
	@Rule
	public WebDriverExecutorRule webRuleWithCustomWebDriverExecutorDriverProvider = new WebDriverExecutorRule(new HtmlUnitDriverProvider());

	@Override
	public WebDriverExecutor getWebDriverExecutor() {
		return webRuleWithCustomWebDriverExecutorDriverProvider.getWebDriverExecutor();
	}
}
