# Poslední tvůrce

Textová adventura o úniku z opuštěného technologického komplexu. Probouzíš se v temné místnosti bez vzpomínek jediným společníkem je umělá inteligence Aurora. Tvým cílem je prozkoumat komplex, odhalit pravdu o své existenci a najít cestu ven.

## Ovládání hry

Hra se ovládá zadáváním příkazů. Po zadání příkazu se často zobrazí číslovaný seznam možností.

## Dostupné příkazy

**Pohyb a průzkum:**
- `jdi` - zobrazí dostupné lokace, vyber číslem kam jít
- `prohledej okolí` - zobrazí detailní popis lokace a dostupné předměty

**Inventář:**
- `inventář` - zobrazí obsah inventáře
- `seber` - zobrazí předměty v místnosti, vyber číslem co sebrat
- `použij` - zobrazí předměty k použití, vyber číslem
- `zahoď` - zobrazí předměty v inventáři, vyber číslem co zahodit
- `popis` - zobrazí předměty, vyber číslem pro detailní popis

**Dialog:**
- `mluv` - zobrazí postavy v místnosti
- `nemluv` - ukončí probíhající dialog

**Souboj:**
- `útok` - zaútočí na nepřítele
- `útěk` - pokusí se utéct ze souboje

**Jiné**
- `stav` - zobrazí tvoje zdraví a statistiky
- `pomoc` - zobrazí seznam všech příkazů
- `konec` - ukončí hru

## Herní mechaniky

### Inventář
- Máš 3 sloty pro předměty
- Některé předměty nezabírají slot
- Předměty lze zahodit pro uvolnění místa
- Některé předměty jsou spotřebovatelné (obvodová deska, kámen)

### Souboj
- Souboje jsou tahové

### Přístupová karta
- Karta odemyká zamčené dveře
- Lze ji vylepšit na vyšší úroveň
- Některé dveře vyžadují kartu určité úrovně

### Minihry
- V některých místnostech jsou minihry (terminály, logické hádanky)
- Úspěšné dokončení otevře cestu dál nebo poskytne odměnu

## Spuštění hry

Hra vyžaduje Java 8 nebo novější.

### Kompilace a spuštění:
```bash
javac Main.java
java Main
```

### V IntelliJ IDEA:
1. Otevři projekt
2. Spusť `Main.java`

## Technické informace

**Použité knihovny:**
- Gson 2.13.1 - pro načítání herních dat z JSON

**Struktura dat:**
- Herní data jsou uložena v `Resources/data.json`
- Dialogy v `Resources/*.txt`

**Architektura:**
- Balíček `hra` - hlavní herní logika
- Balíček `lokace` - jednotlivé herní místnosti
- Balíček `prikaz` - implementace herních příkazů
- Balíček `predmety` - herní předměty
- Balíček `postavy` - NPC postavy
- Balíček `nepratel` - nepřátelé
- Balíček `minihra` - minihry v různých lokacích

## Tipy

- Zkoumej každou místnost pomocí `prohledej`
- Mluvte se všemi postavami - mohou poskytnout důležité informace
- Kámen je extrémně efektivní proti dronům
