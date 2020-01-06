package org.gradle.docs.guides

import org.gradle.docs.AbstractBaseDocumentationFunctionalTest
import org.gradle.docs.TestFile

class GuidesBaseDocumentationFunctionalTest extends AbstractBaseDocumentationFunctionalTest implements GuidesTrait {
    @Override
    protected String createDocumentationElement(String name) {
        return createGuide(name)
    }

    @Override
    protected String documentationDsl(String name) {
        return guideDsl(name)
    }

    @Override
    protected void makeSingleProject() {
        buildFile << applyDocumentationPlugin() << createGuide('demo')
    }

    @Override
    protected void writeDocumentationUnderTest() {
        writeContentTo(file('src/docs/guides/demo'))
    }

    @Override
    protected TestFile getContentFileUnderTest() {
        return file('src/docs/guides/demo/contents/index.adoc')
    }
}