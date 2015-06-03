/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.language.base.internal.resolve;

import org.gradle.api.artifacts.ResolveContext;
import org.gradle.api.artifacts.component.LibraryComponentIdentifier;
import org.gradle.api.internal.artifacts.configurations.ResolutionStrategyInternal;
import org.gradle.api.internal.artifacts.ivyservice.resolutionstrategy.DefaultResolutionStrategy;
import org.gradle.language.base.sources.BaseLanguageSourceSet;

public abstract class DefaultLanguageSourceSetResolveContext implements ResolveContext {
    private final String projectPath;
    private final BaseLanguageSourceSet sourceSet;
    private final ResolutionStrategyInternal resolutionStrategy = new DefaultResolutionStrategy();

    public DefaultLanguageSourceSetResolveContext(String projectPath, BaseLanguageSourceSet sourceSet) {
        this.projectPath = projectPath;
        this.sourceSet = sourceSet;
    }

    protected String getLibraryName() {
        return sourceSet.getParentName();
    }

    public BaseLanguageSourceSet getSourceSet() {
        return sourceSet;
    }

    @Override
    public String getName() {
        return LibraryComponentIdentifier.API_CONFIGURATION_NAME;
    }

    public String getProjectPath() {
        return projectPath;
    }

    @Override
    public ResolutionStrategyInternal getResolutionStrategy() {
        return resolutionStrategy;
    }
}
