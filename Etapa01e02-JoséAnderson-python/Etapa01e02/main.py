import requests
from bs4 import BeautifulSoup
import csv

base_url = 'https://ge.globo.com/futebol/times/sao-paulo/noticia/2023/07/29/sao-paulo-anuncia-a-contratacao-do-meia-james-rodriguez.ghtml'

response = requests.get(base_url)
html_content = response.content

soup = BeautifulSoup(html_content, 'html.parser')

# Encontrar todos os elementos <p> e filtrar aqueles que contêm o texto "futebol"
futebol_paragraphs = [p for p in soup.find_all('p') if "futebol" in p.get_text().lower()]

# Criar um arquivo CSV chamado "dados.csv" e escrever os dados filtrados
csv_filename = "dados.csv"

with open(csv_filename, mode='w', newline='', encoding='utf-8') as csv_file:
    fieldnames = ["texto"]
    writer = csv.DictWriter(csv_file, fieldnames=fieldnames)

    writer.writeheader()

    for paragraph in futebol_paragraphs:
        writer.writerow({"texto": paragraph.get_text().strip()})
