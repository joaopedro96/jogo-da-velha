# ❌ Jogo da Velha ⭕
> Implementação em Java puro com orientação a objetos, padrão MVC e boas práticas de design.

<br>

## Demonstração

```
╔══════════════════════════════╗
║     JOGO DA VELHA  v1.0      ║
╚══════════════════════════════╝

  [1]  Novo jogo
  [2]  Ver placar
  [3]  Como jogar
  [4]  Configurar jogadores
  [0]  Sair
──────────────────────────────
Escolha uma opção:
```

```
  col:  0   1   2
linha 0:  X | O | X
         ---+---+---
linha 1:    | X |  
         ---+---+---
linha 2:  O |   | X

╔══════════════════════════════╗
║    Alice venceu! Parabéns!   ║
╚══════════════════════════════╝
```

<br>

## Funcionalidades

- **Dois jogadores** no mesmo console
- **Menu interativo** com navegação por opções
- **Placar persistente** entre rodadas
- **Configuração de nomes** dos jogadores
- **Validação de jogadas** com mensagens de erro claras
- **Detecção automática** de vitória e empate

<br>

## Tecnologias

![Java](https://img.shields.io/badge/Java-24-orange?style=flat-square&logo=openjdk)
![Gradle](https://img.shields.io/badge/Gradle-8-blue?style=flat-square&logo=gradle)
![MVC](https://img.shields.io/badge/Padrão-MVC-green?style=flat-square)
![Singleton](https://img.shields.io/badge/Design_Pattern-Singleton-purple?style=flat-square)

<br>

## Arquitetura

O projeto segue o padrão **MVC** com separação clara de responsabilidades:

```
src/
├── Main.java                          # Ponto de entrada
├── controller/
│   ├── MenuController.java            # Loop do menu principal
│   └── GameController.java            # Loop da partida
├── model/
│   ├── Board.java                     # Estado e regras do tabuleiro
│   ├── Player.java                    # Dados do jogador
│   ├── Scoreboard.java                # Placar acumulado
│   ├── Coordinate.java                # Posição no tabuleiro
│   └── MenuOption.java                # Enum das opções do menu
├── view/
│   └── GameView.java                  # Toda saída para o console
└── exceptions/
    ├── InvalidCoordinateException.java
    └── PositionAlreadyTakenException.java
```

### Diagrama de classes

```
MenuController ──cria──► GameController
      │                        │
      │                        ├──► Board         (estado + regras)
      ├──► Scoreboard ◄─────── │    ├── hasVictory()
      │    (compartilhado)      │    ├── hasDraw()
      │                        │    └── updateBoard()
      └──► GameView ◄──────────┘
           (compartilhada)
```

### Padrões utilizados

| Padrão | Onde | Por quê |
|--------|------|---------|
| **MVC** | Toda a aplicação | Separação de responsabilidades |
| **Singleton** | `Game` | Garantir única instância do jogo |
| **Conventional Commits** | Git | Histórico legível em equipe |

<br>

## Como rodar

### Pré-requisitos

- Java 14 ou superior
- Gradle (ou use o wrapper incluso)

### Clonando o projeto

```bash
git clone https://github.com/joaopedro96/jogo-da-velha.git
cd jogo-da-velha
```

### Executando

```bash
# Com Gradle
./gradlew run

# Ou compilando manualmente
javac -d out src/**/*.java
java -cp out Main
```

<br>

## Como jogar

1. Ao iniciar, configure os nomes dos jogadores no menu (opção `4`)
2. Escolha **Novo jogo** (opção `1`)
3. Em cada turno, informe a **linha** e a **coluna** desejadas (valores de `0` a `2`)
4. Vence quem completar uma linha, coluna ou diagonal primeiro
5. O placar acumula entre partidas — use a opção `2` para consultar

### Mapa do tabuleiro

```
  col:  0   1   2
linha 0:  _ | _ | _
         ---+---+---
linha 1:  _ | _ | _
         ---+---+---
linha 2:  _ | _ | _
```

<br>


<br>

## Histórico de versões

| Versão | O que mudou |
|--------|-------------|
| `v1.0` | Jogo completo com menu, placar e validação |
| `v0.3` | Scoreboard e múltiplas rodadas |
| `v0.2` | GameController e fluxo completo de partida |
| `v0.1` | Board e GameView com separação MVC |

<br>

## Próximas melhorias

- [ ] Modo single player com IA simples (minimax)
- [ ] Dificuldades: fácil, médio, difícil
- [ ] Salvar histórico de partidas em arquivo
- [ ] Versão com interface gráfica (JavaFX ou SING)

<br>

---

<p align="center">
  Feito com ☕ Java por um time de 3
</p>
