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
package richtercloud.document.scanner.model;

import java.util.Collections;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

/**
 *
 * @author richter
 */
@Entity
public class Person extends Company {
    private static final long serialVersionUID = 1L;
    @ElementCollection
    private List<String> firstnames;
    @ElementCollection
    private List<String> lastnames;

    protected Person() {
    }

    public Person(Long id, List<String> firstnames, List<String> lastnames, String name, List<String> allNames, List<Address> addresses, List<EmailAddress> emails) {
        super(id, name, allNames, addresses, emails);
        this.firstnames = firstnames;
        this.lastnames = lastnames;
    }

    /**
     * @return the firstnames
     */
    public List<String> getFirstnames() {
        return Collections.unmodifiableList(this.firstnames);
    }

    /**
     * @param firstnames the firstnames to set
     */
    public void setFirstnames(List<String> firstnames) {
        this.firstnames = firstnames;
    }

    /**
     * @return the lastnames
     */
    public List<String> getLastnames() {
        return Collections.unmodifiableList(this.lastnames);
    }

    /**
     * @param lastnames the lastnames to set
     */
    public void setLastnames(List<String> lastnames) {
        this.lastnames = lastnames;
    }
}
