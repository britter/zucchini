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

package de.codecentric.zucchini.web.results;

import static de.codecentric.zucchini.bdd.util.Assert.assertTrue;

public class SeeResult extends AbstractWebResult {
	private String text;

	public SeeResult(String text) {
		this.text = text;
	}

	@Override
	public void expect() {
		assertTrue(String.format("Page should contain \"%s\" but it does not.", text), getWebDriver().getPageSource().contains(text));
	}
}
