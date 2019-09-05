# PokemonsAPI

API for Pokemon data colletions

Sample URL: http://localhost:8080/api/pokemon?name=Pikachu

Sample JSON:

```json
{
"id": 31,
"number": 25,
"name": "Pikachu",
"types": [
{
"id": 5,
"name": "Electric"
}
],
"total": 320,
"healthPoints": 35,
"attack": 55,
"defense": 40,
"specialAttack": 50,
"specialDefence": 50,
"speed": 90,
"generation": 1,
"legendary": false
}
```


## Show single Pokemon

Returns json data about single pokemon

**URL**
```url
/api/pokemon
```
**Method**
```
GET
```
**URL Params**
```
{id}
{name} - may return list
{number}  
```





## Show list of Pokemons

Returns json data list with pokemons



**URL**
```
/api/pokemon/list
```
**Method**
```
GET
```
**URL Params**
```
{generation}
{type}
```
<br/><br/><br/>

**URL**
```
/api/pokemon/list/all
```
**Method**
```
GET
```
**URL Params** -
Return all Pokemons from database

<br/><br/><br/>

**URL**
```
/api/pokemon/list/legendaries
```
**Method**
```
GET
```
**URL Params**
```
{isLegendary} : true or false
```
Return all legendary or non legendery Pokemons

<br/><br/><br/>

**URL**
```
/api/pokemon/list/type
```
**Method**
```
GET
```
**URL Params**
```
{name} 
```
```
| id | name     |
+----+----------+
|  1 | Water    |
|  2 | Fighting |
|  3 | Rock     |
|  4 | Ground   |
|  5 | Electric |
|  6 | Ice      |
|  7 | Grass    |
|  8 | Normal   |
|  9 | Steel    |
| 10 | Dragon   |
| 11 | Flying   |
| 12 | Psychic  |
| 13 | Bug      |
| 14 | Ghost    |
| 15 | Dark     |
| 16 | Fire     |
| 17 | Poison   |
| 18 | Fairy    |
```
Return all pokemons with given type name

<br/><br/><br/>

**URL**
```
/api/pokemon/list/generation
```
**Method**
```
GET
```

**URL Params**
```
{number} 
```
```
 generation |
+------------+
|          1 |
|          2 |
|          3 |
|          4 |
|          5 |
|          6 |
```
Return all pokemons with given generation number
