/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.docs.guides;

import org.gradle.api.Named;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.provider.Property;

/**
 * @since 0.1
 */
public interface Guide extends Named, GuideSummary {
    /**
     * By convention, this is the guide name off the extension's guide root directory.
     *
     * @return Property for configuring the guide root directory.
     */
    DirectoryProperty getGuideDirectory();

    /**
     * Path of repository relative to {@code https://github.com}.
     * @since 0.15.8
     */
    Property<String> getRepositoryPath();

    /**
     * Minimum Gradle version this guide works on.
     * @since 0.15.7
     */
    Property<String> getMinimumGradleVersion();

    /**
     * Short description of the guide.
     * @since 0.15.8
     */
    Property<String> getDescription();

    /**
     * Title of the guide.
     * @since 0.15.8
     */
    Property<String> getTitle();
}
