# MySQL Docker Playground

A complete Docker setup for MySQL development and experimentation.

## Features

- **MySQL 8.0** container
- **phpMyAdmin** web interface for database management
- **Data persistence** with Docker volumes
- **Health checks** to ensure container readiness
- **Sample data** with init scripts

## Quick Start

### Prerequisites

- Docker
- Docker Compose

### Starting the containers

```bash
docker-compose up -d
```

This will start:
- MySQL on `localhost:3306`
- phpMyAdmin on `http://localhost:8080`

### Stopping the containers

```bash
docker-compose down
```

### Stopping and removing all data

```bash
docker-compose down -v
```

## Configuration

Edit the `.env` file to customize:

```env
MYSQL_ROOT_PASSWORD=root
MYSQL_DATABASE=playground
MYSQL_USER=playground
MYSQL_PASSWORD=playground123
```

## Connecting to MySQL

### From command line

```bash
mysql -h 127.0.0.1 -u playground -p
# Password: playground123
```

### From application

```
Host: localhost
Port: 3306
User: playground
Password: playground123
Database: playground
```

## phpMyAdmin Access

Open your browser and navigate to: **http://localhost:8080**

- Username: `playground` (or `root`)
- Password: (as configured in `.env`)

## Initialization Scripts

SQL files in the `init-scripts/` directory will automatically run when the container starts for the first time. Add your own `.sql` files here to set up additional databases, tables, or data.

## Sample Data

The default initialization script creates:
- `users` table with 3 sample users
- `posts` table with 3 sample posts

## Tips

- View logs: `docker-compose logs mysql`
- View running containers: `docker-compose ps`
- Execute MySQL commands: `docker-compose exec mysql mysql -u root -p`
- Backup database: `docker-compose exec mysql mysqldump -u root -p playground > backup.sql`
- Restore database: `docker-compose exec mysql mysql -u root -p playground < backup.sql`

## Cleanup

To remove everything including the MySQL data volume:

```bash
docker-compose down -v
```
