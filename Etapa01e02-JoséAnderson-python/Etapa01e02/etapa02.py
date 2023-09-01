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
                "database": "futebol"
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

    def commit(self):
        self.conn.commit()

    # Resto do código da classe Connection

class TextoFutebol(Connection):
    def __init__(self):
        super().__init__()

    def insert(self, id, texto):
        try:
            sql = "INSERT INTO textofutebol (id, texto) VALUES (%s, %s)"
            self.cur.execute(sql, (id, texto))  # Usar self.cur.execute em vez de self.execute
            self.commit()
            print('Succesfully inserted!')
        except Exception as e:
            print("Erro ao inserir", e)

def main():
    textofutebol = TextoFutebol()

    with open('dados.csv', 'r', newline='', encoding='utf-8') as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)  # Pule a primeira linha se ela contiver cabeçalhos
        for row in csv_reader:
            id = int(row[0])
            texto = row[1]
            textofutebol.insert(id, texto)

    textofutebol.conn.close()  # Fechar a conexão após inserções

if __name__ == "__main__":
    main()
