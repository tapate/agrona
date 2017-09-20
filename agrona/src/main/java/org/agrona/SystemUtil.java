/*
 * Copyright 2014-2017 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.agrona;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Utilities for inspecting the system.
 */
public class SystemUtil
{
    private static final String OS_NAME;

    static
    {
        OS_NAME = System.getProperty("os.name").toLowerCase();
    }

    /**
     * Get the name of the operating system as a lower case String.
     * <p>
     * This is what is returned from System.getProperty("os.name").toLowerCase().
     *
     * @return the name of the operating system as a lower case String.
     */
    public static String osName()
    {
        return OS_NAME;
    }

    /**
     * Is a debugger attached to the JVM?
     *
     * @return true if attached otherwise false.
     */
    public static boolean isDebuggerAttached()
    {
        final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        for (final String arg : runtimeMXBean.getInputArguments())
        {
            if (arg.contains("-agentlib:jdwp"))
            {
                return true;
            }
        }

        return false;
    }
}
