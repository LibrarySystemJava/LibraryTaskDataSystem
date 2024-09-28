CREATE TABLE IF NOT EXISTS book (
    isbn VARCHAR(14) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    borrower VARCHAR(255)
    );

INSERT INTO book (isbn, title, author, category)
VALUES
    ('978-8308057011', 'Pan Tadeusz', 'Adam Mickiewicz', 'Poematy epickie'),
    ('978-8375108741', 'Lalka', 'Bolesław Prus', 'Powieść'),
    ('978-0345803481', '50 twarzy Greya', 'E.L. James', 'Romans'),
    ('978-8324588186', 'Wiedźmin: Ostatnie życzenie', 'Andrzej Sapkowski', 'Fantasy');

INSERT INTO book (isbn, title, author, category, borrower)
VALUES
    ('978-0140447941', 'Zbrodnia i kara', 'Fiodor Dostojewski', 'Powieść', 'Tomek');