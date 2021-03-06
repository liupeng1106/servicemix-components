/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.servicemix.eip.support;

import junit.framework.TestCase;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class NamespaceContextImplTest extends TestCase {

    public void testNsContext() throws Exception {
        ClassPathXmlApplicationContext springContext = 
            new ClassPathXmlApplicationContext(new String[] { "org/apache/servicemix/eip/support/nscontext.xml" }, false);
        springContext.setValidating(false);
        springContext.refresh();
        Object objNsContext = springContext.getBean("nsContext");
        assertNotNull(objNsContext);
        assertTrue(objNsContext instanceof NamespaceContextImpl);
        NamespaceContextImpl nsContext = (NamespaceContextImpl) objNsContext;
        assertEquals("urn:test", nsContext.getNamespaceURI("test"));
        assertEquals("test", nsContext.getPrefix("urn:test"));
    }
    
}
