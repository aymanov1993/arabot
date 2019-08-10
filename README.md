# Wiki
## Installation steps
- Prepare mySQL database with the following details (database name = wiki, username = root, password = admin, port = 3306)
- Create pages table with following schema 
CREATE TABLE IF NOT EXISTS pages (
    page_id INT,
    title VARCHAR(255) NOT NULL,
    creation_date timestamp default now(),
    description TEXT,
    PRIMARY KEY (page_id)
)
- git clone https://github.com/aymanov1993/arabot.git
- Run mvn exec:java

### Project APIs
- /wiki/fill to fill the database with Amman, Jordan articles
- /wiki/pages?keyword= to search in the stored data
- /wiki/report generate report
