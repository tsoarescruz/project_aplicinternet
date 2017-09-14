# Aplicação Internet UVA 2017.2

### Alguns Comandos do GIT

### (1) Como baixar um repositorio no GIT

#### SSH

```bash
git clone git@github.com:tsoarescruz/aplicinternet.git
```

#### HTTPS

```bash
git clone https://github.com/tsoarescruz/aplicinternet.git 

```

### (2) Como trazer os arquivos alterados ao git

#### Traz as modificações sem aplicar

```bash
git fetch

```

#### Traz as modificações e aplica

```bash
git pull

```

### (3) Como adicionar arquivos alterados ao git

#### Adiciona um arquivo específico

```bash
git add README.md 

```

#### Adiciona todos os arquivos modificados

```bash
git add .

```

### (4) Como commitar as modificacoes

```bash
git commit -m "mensagem do commit"
```

### (5) Como dar push para o remoto

```bash
git push -u origin master
```

### (6) Como dar criar um novo branch para trabalhar

```bash
git checkout -b <nome_do_branch>
```

### (7) Como dar push para o novo branch para trabalhar

```bash
git push origin <nome_do_branch>
```


### (8) Como desfazer alteracoes em um arquivo

```bash
git checkout <nome_do_arquivo>
```
