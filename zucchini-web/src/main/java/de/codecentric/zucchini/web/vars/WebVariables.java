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

package de.codecentric.zucchini.web.vars;

import de.codecentric.zucchini.bdd.vars.Variable;
import de.codecentric.zucchini.web.pageobjects.PageObject;

/**
 * This utility class provides shorthand methods used as web-specific variable placeholders.
 */
public class WebVariables {
    /**
     * Returns a variable that contains a {@link de.codecentric.zucchini.web.pageobjects.PageObject}.
     *
     * @param variableName The name of the variable.
     * @return A variable that contains a string.
     */
    public static Variable<PageObject> pageVar(String variableName) {
        return new PageObjectVariable(variableName);
    }

    private WebVariables() {
    }
}
