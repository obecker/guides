package org.gradle.docs.samples;

import org.gradle.api.Action;
import org.gradle.api.Named;
import org.gradle.api.Task;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.TaskProvider;

/**
 * Represent a sample to be documented. Each sample must contain at least a Groovy or Kotlin DSL sample.
 */
public interface Sample extends Named, SampleSummary {
    /**
     * By convention, this is the sample name off the extension's sample root directory.
     *
     * @return Property for configuring the sample root directory.
     */
    DirectoryProperty getSampleDirectory();

    /**
     * @return The README file for the sample.
     *
     * By convention, this is README.adoc in the sample directory.
     */
    RegularFileProperty getReadMeFile();

    /**
     * @return The LICENSE file for the sample.
     *
     * By convention, this is LICENSE in the sample directory.
     */
    RegularFileProperty getLicenseFile();

    /**
     * @return Sample content that is shared by all DSLs.
     *
     * By convention, this is the wrapper files, README and LICENSE.
     */
    ConfigurableFileCollection getCommonContent();

    /**
     * Configure common content.
     *
     * @param action configuration action
     */
    void common(Action<? super ConfigurableFileCollection> action);

    /**
     * By convention, this is the "groovy" directory in the sample directory.
     *
     * @return Sample content that is used for Groovy DSL.
     */
    ConfigurableFileCollection getGroovyContent();

    /**
     * Configure Groovy content.
     *
     * @param action configuration action
     */
    void groovy(Action<? super ConfigurableFileCollection> action);

    /**
     * By convention, this is the "kotlin" directory in the sample directory.
     *
     * @return Sample content that is used for Kotlin DSL.
     */
    ConfigurableFileCollection getKotlinContent();

    /**
     * Configure Kotlin content.
     *
     * @param action configuration action
     */
    void kotlin(Action<? super ConfigurableFileCollection> action);

    /**
     * @return Sample content that is used for Exemplar testing
     */
    ConfigurableFileCollection getTestsContent();

    /**
     * Configure testing content.
     *
     * @param action configuration action
     */
    void tests(Action<? super ConfigurableFileCollection> action);

    /**
     * @return Root installation directory for each DSL.
     */
    DirectoryProperty getInstallDirectory();

    /**
     * @return Root installation directory for each DSL when tested.
     */
    DirectoryProperty getTestedInstallDirectory();

    /**
     * This is an asciidoc file, not the generated HTML.
     *
     * @return The generated sample (asciidoc) page.
     */
    RegularFileProperty getSamplePageFile();

    /**
     * @return Lifecycle task for assembling this sample.
     */
    TaskProvider<Task> getAssembleTask();

    /**
     * @return Lifecycle task for checking this sample.
     */
    TaskProvider<Task> getCheckTask();
}
