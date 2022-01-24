/*
 * Copyright 2017-2022 the original author or authors.
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
package io.allune.quickfixj.spring.boot.actuate.config;

import io.allune.quickfixj.spring.boot.actuate.endpoint.QuickFixJServerEndpoint;
import io.allune.quickfixj.spring.boot.starter.autoconfigure.server.QuickFixJServerAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quickfix.Acceptor;
import quickfix.SessionSettings;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for {@link QuickFixJServerEndpoint}.
 *
 * @author Eduardo Sanchez-Ros
 */
@Configuration
@AutoConfigureAfter(QuickFixJServerAutoConfiguration.class)
public class QuickFixJServerEndpointAutoConfiguration {

	@Bean
	@ConditionalOnBean(name = { "serverAcceptor", "serverSessionSettings" })
	@ConditionalOnClass({ Acceptor.class, SessionSettings.class })
	@ConditionalOnMissingBean
	@ConditionalOnAvailableEndpoint
	public QuickFixJServerEndpoint quickfixjServerEndpoint(Acceptor serverAcceptor, SessionSettings serverSessionSettings) {
		return new QuickFixJServerEndpoint(serverAcceptor, serverSessionSettings);
	}
}
