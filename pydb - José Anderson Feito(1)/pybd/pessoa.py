import psycopg2 as db
import csv

class Config:
    def __init__(self):
        self.config = {
            "postgres": {
                "user": "postgres",
                "password": "postgres",
                "host": "localhost",
                "port": "5432",
                "database": "pydb"
            }
        }

class Connection(Config):
    def __init__(self):
        super().__init__()

        try:
            self.conn = db.connect(**self.config["postgres"])
            self.cur = self.conn.cursor()

        except Exception as e:
            print("Erro na conexão", e)
            exit(1)

    def __enter__(self):
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.commit()
        self.conn.close()

    @property
    def connection(self):
        return self.conn

    @property
    def cursor(self):
        return self.cur

    def commit(self):
        self.connection.commit()

    def fetchall(self):
        return self.cursor.fetchall()

    def execute(self, sql, params=None):
        self.cursor.execute(sql, params or ())

    def query(self, sql, params=None):
        self.cursor.execute(sql, params or ())
        return self.fetchall()

class Pessoa(Connection):
    def __init__(self):
        super().__init__()

    def insert(self, *args):
        try:
            sql = "INSERT INTO pessoa(nome) VALUES (%s)"
            self.execute(sql, args)
            self.commit()

        except Exception as e:
            print("Erro ao inserir", e)
          
    def insert_csv(self, filename):
        try:
            data = csv.DictReader(open(filename, encoding="utf-8"))
            for row in data:
                self.insert(row["nome"])
                print("Registro inserido")
        except Exception as e:
            print("Erro ao inserir csv", e)

    def delete(self, id):
        try:
            sql_s = f"SELECT * FROM pessoa WHERE id = {id}"
            print("Checando no banco de dados:", sql_s)
            if not self.query(sql_s):
                return "Registro não encontrado para deletar"
            sql_d = f"DELETE FROM pessoa WHERE id = {id}"
            print("Delete query:", sql_d)
            self.execute(sql_d)
            self.commit()
            return "Registro Deletado com sucesso"

        except Exception as e:
            print("Erro ao deletar", e)

    def update(self, id, *args):
      try:
          sql = f"UPDATE pessoa SET nome = %s WHERE id = {id}"
          self.execute(sql, args)
          self.commit()
          print("Registro Atualizado")

      except Exception as e:
          print("Erro ao Atualizar", e)


if __name__ == "__main__":
    pessoa = Pessoa()
    # pessoa.insert("Maria")
    # pessoa.update(5, "Maria Antônio")
    pessoa.insert_csv("data.csv")
    # pessoa.update(1, "José Anderson")

