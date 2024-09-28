db.getSiblingDB("books").createUser(
    {
        user: "admin",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "books"
            }
        ]
    }
);
