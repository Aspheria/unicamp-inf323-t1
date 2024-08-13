O construtor da classe Book inicializa um novo objeto Book com os
seguintes parˆametros:
id: Identificador ´unico do livro (herdado da classe pai).
title: T´ıtulo do livro (herdado da classe pai).
pubDate: Data de publica¸c˜ao do livro.
publisher: Nome do editor do livro.
subject: Assunto do livro (do tipo Subject).
desc: Descri¸c˜ao do livro.
thumbnail: URL da imagem em miniatura do livro.
image: URL da imagem de capa do livro.
srp: Pre¸co de venda sugerido do livro.
avail: Data de disponibilidade do livro.
isbn: N´umero ISBN do livro.
page: N´umero de p´aginas do livro.
backing: Tipo de encaderna¸c˜ao do livro (do tipo Backing).
dimensions: Dimens˜oes do livro.
author: Autor do livro (do tipo Author).

Al´em disso, ele faz uma chamada para o construtor da superclasse Item,
passando os parˆametros id e title


O construtor realiza diversas valida¸c˜oes para garantir a integridade dos
dados:
pubDate: Validado para n˜ao ser nulo.
publisher: Validado para estar no formato correto e n˜ao exceder o
comprimento m´aximo.
subject: Validado para n˜ao ser nulo.
desc, thumbnail, image, dimensions: Validados para n˜ao
excederem os comprimentos m´aximos permitidos.
avail: Validado para n˜ao ser nulo.
isbn: Validado para estar no formato correto de ISBN.
srp, page: Validados para serem valores positivos.
backing: Validado para n˜ao ser nulo.
author: Validado para n˜ao ser nulo.
