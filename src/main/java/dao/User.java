package dao;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
   private int id;
   private String firstName;
   private String lastName;
   private Company company;

   public User id (int id) {
      this.id = id;
      return this;
   }

   public User firstName (String firstName) {
      this.firstName = firstName;
      return this;
   }

   public User lastName (String lastName) {
      this.lastName = lastName;
      return this;
   }

   public User company (Company company) {
      this.company = company;
      return this;
   }

}
