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

package de.codecentric.zucchini.bdd.dsl.impl.facts;

import de.codecentric.zucchini.bdd.dsl.DelegatingStatement;
import de.codecentric.zucchini.bdd.dsl.Fact;
import de.codecentric.zucchini.bdd.resolver.StatementResolverHolder;

public class DelegatingFact implements Fact, DelegatingStatement<Fact> {
	private String factName;

	private Fact fact;

	public DelegatingFact(String factName) {
		this.factName = factName;
	}

	@Override
	public void establish() {
		getStatement().establish();
	}

	@Override
	public Fact getStatement() {
		if (fact == null) {
			fact = StatementResolverHolder.getStatementResolver().resolveStatement(factName, Fact.class);
		}
		return fact;
	}
}