package com.liferay.gs.activator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by eduardo on 6/09/17.
 */
public class MyActivator implements BundleActivator {

    Log log = LogFactoryUtil.getLog("MyActivator");

    public void start(BundleContext context) throws Exception {
        log.fatal("Sample activator starting");
    }

    public void stop(BundleContext context) throws Exception {
        log.fatal("Sample activator stopping");
    }
}

