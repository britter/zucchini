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

import de.codecentric.zucchini.bdd.dsl.Result;
import de.codecentric.zucchini.bdd.resolver.StatementResolverHolder;
import de.codecentric.zucchini.web.results.WebResult;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * This JUnit {@link org.junit.rules.TestRule rule} provides a mechanism for registering a web result with a specific
 * name.
 */
public class WebResultRule implements TestRule {
	private final String resultName;
	private final WebResult webResult;

	/**
	 * Initializes a web result rule that registers the given {@link de.codecentric.zucchini.web.results.WebResult web result}
	 * with the specified name.
	 *
	 * @param resultName The name used to reference the result afterwards.
	 * @param webResult  The {@link de.codecentric.zucchini.web.results.WebResult web result}.
	 */
	public WebResultRule(String resultName, WebResult webResult) {
		this.resultName = resultName;
		this.webResult = webResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Statement apply(final Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				StatementResolverHolder.getStatementResolver().addStatement(resultName, webResult, Result.class);
				base.evaluate();
			}
		};
	}
}
