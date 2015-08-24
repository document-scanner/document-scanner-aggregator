/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package richtercloud.document.scanner.setter;

import richtercloud.reflection.form.builder.jpa.IdPanel;

/**
 *
 * @author richter
 */
public class IdSpinnerSetter implements ValueSetter<IdPanel>{
    private final static IdSpinnerSetter INSTANCE = new IdSpinnerSetter();

    public static IdSpinnerSetter getInstance() {
        return INSTANCE;
    }

    protected IdSpinnerSetter() {
    }

    @Override
    public void setValue(String value, IdPanel comp) {
        comp.getIdSpinner().setValue(value);
    }
    
}
