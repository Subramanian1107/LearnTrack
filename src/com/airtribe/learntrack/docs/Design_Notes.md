Why ArrayList instead of Array?

ArrayList is used because it provides dynamic resizing. Unlike arrays, which have a fixed size once created, an ArrayList can grow or shrink at runtime as elements are added or removed. This makes the code more flexible and easier to maintain.

Where you used static members and why?

static members are used for the IdGenerator objects since they have to class specific and not indiviual object specific.

Where inheritance was used and what was gained from it?

Person class is the parent class which is inherited by both Student class and a Trainer class. Both have own implementations of display method. The common behaviour is inherited from the parent and the unique behaviour is used for each class.
By using inheritance, the code gained reusability, extensibility, and polymorphism.