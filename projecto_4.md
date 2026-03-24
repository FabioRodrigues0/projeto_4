---
tags:
  - contexto/PC
  - tipo/trabalho_pratico
  - conceito/java
  - area/programacao
data: 24-03-2026
disciplina:
  - PC
---

# Código Secreto

## Descrição do Projeto

O objetivo deste projeto consiste em descobrir um código secreto de 4 dígitos. Para atingir este objetivo, sabe-se o seguinte:

Os 4 dígitos do código correspondem aos códigos ASCII de duas letras, em maiúsculas, do nome encriptado do autor ou autora de um texto. 
Desse texto, sabe-se que está escrito em inglês, mas apenas se tem acesso a uma versão encriptada e que é fornecida em anexo. 
Sabe-se ainda que o processo de encriptação deste texto necessita de uma palavra-chave e que essa palavra-chave é “knowledge” em maiúsculas. 
Sabe-se também que o processo de encriptação passa por somar as letras do texto com as letras da palavra-chave, tendo em conta a posição que cada uma ocupa no alfabeto de 26 letras. 
O resultado da soma, convertido para a posição do alfabeto e adicionando um valor correspondente ao tamanho da palavra-chave, permite obter a letra do texto encriptado. 
O processo apenas considera os caracteres alfabéticos do texto original ignorando todos os outros caracteres.
O código secreto é obtido da forma seguinte: a partir do nome encontrado para o/a autor/a do texto, por sua vez encriptado com a palavra-chave “future” (considerando sempre os caracteres em maiúsculas), os códigos ASCII dos dois últimos caracteres do nome encriptado constituem os quatro dígitos do código.

Para cumprir o objetivo do projeto terá de ser desenvolvido um programa em Java que permita obter o código secreto pretendido.


Validação da solução encontrada e do projeto desenvolvido

Para validar a solução encontrada para o problema, estará disponível da portaria do ISPGAYA um cofre que abre com um PIN de 4 dígitos e que é o código secreto pretendido.
Cada grupo que tenha encontrado o código deverá dirigir-se à portaria, verificar se o código abre o cofre e, em caso afirmativo, deverá colocar uma folha com a identificação dos elementos do grupo e com o dia e a hora de abertura do cofre (e poderá recolher algum prémio que exista por ter conseguido abrir o cofre). O dia e hora de abertura do cofre terá de ser posterior ao dia e hora de submissão do projeto.
Na demonstração do projeto têm de ficar claros todos os passos que levaram à descoberta do código secreto usando o programa em Java desenvolvido. O programa deverá permitir a encriptação/desencriptação de qualquer mensagem de texto.
O projeto é considerado concluído com a submissão do programa em Java no Inforestudante e com a abertura do cofre com o código encontrado.

## Outros requisitos

O código do programa deve estar dividido em métodos;
O código deve estar devidamente comentado:
Caso seja utilizado código que não seja original do estudante, este deve estar claramente identificado e conter referência à fonte.
É autorizada a utilização de ferramentas de Inteligência Artificial, desde que:
• As prompts utilizadas sejam entregues juntamente com o projeto;
• Seja claramente indicado que foi usado apoio de IA;
• O estudante compreenda e consiga explicar todo o código apresentado e efetuar alterações sobre esse código.

## Relações
- [[variavel]]
- [[tipo_primitivo]]
