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

import static de.codecentric.zucchini.bdd.util.Assert.assertEquals;
import static de.codecentric.zucchini.web.util.WebAssert.findElementOrFail;

public class InputValueResult extends AbstractWebResult {
	private final InputContext inputContext;
	private final String value;

	public InputValueResult(InputContext inputContext, String value) {
		this.inputContext = inputContext;
		this.value = value;
	}


	@Override
	public void expect() {
		assertEquals("Element should be read-only but it is not.", value, findElementOrFail(getWebDriver(), inputContext.getElement()).getAttribute("value"));
	}
}
