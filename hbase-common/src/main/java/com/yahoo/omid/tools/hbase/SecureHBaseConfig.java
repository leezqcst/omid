/**
 * Copyright 2011-2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.omid.tools.hbase;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class SecureHBaseConfig {

    public static final String HBASE_CLIENT_PRINCIPAL_KEY = "hbase.client.principal";
    public static final String HBASE_CLIENT_KEYTAB_KEY = "hbase.client.keytab";

    private String principal = "not set";
    private String keytab = "not set";

    // ----------------------------------------------------------------------------------------------------------------
    // WARNING: Do not remove getters/setters, needed by snake_yaml!
    // ----------------------------------------------------------------------------------------------------------------

    public String getPrincipal() {
        return principal;
    }

    @Inject(optional = true)
    @Named(HBASE_CLIENT_PRINCIPAL_KEY)
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getKeytab() {
        return keytab;
    }

    @Inject(optional = true)
    @Named(HBASE_CLIENT_KEYTAB_KEY)
    public void setKeytab(String keytab) {
        this.keytab = keytab;
    }

}
