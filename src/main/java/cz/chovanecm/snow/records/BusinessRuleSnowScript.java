/*
 * Snow Script Synchronizer is a tool helping developers to write scripts for ServiceNow
 *     Copyright (C) 2015-2017  Martin Chovanec <chovamar@fit.cvut.cz>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cz.chovanecm.snow.records;

import cz.chovanecm.snow.RecordAccessor;
import cz.chovanecm.snow.tables.SnowTable;

import java.io.IOException;

public class BusinessRuleSnowScript extends SnowScript implements TableBasedObject {

    private String tableName = "";
    private String when = "";

    public BusinessRuleSnowScript(String sysId, String scriptName, String script, SnowTable table) {
        super(sysId, scriptName, script, table);
    }

    public BusinessRuleSnowScript(SnowTable table) {
        super(table);
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String businessRuleOnTable) {
        this.tableName = businessRuleOnTable;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    @Override
    public void save(RecordAccessor destination) throws IOException {
        destination.saveBusinessRule(this);
    }

}
