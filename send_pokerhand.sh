#!/bin/bash

JSON_DATA="{
\"handinfo\":{
\"location\":\"Göteborg\", \"gameType\":\"Cashgame\",\"smallBlind\":25, \"bigBlind\":25},
\"players\":[
         {\"name\":\"Max\", \"stack\":\"5000\", \"position\":\"SB\",\"card1\":\"Kh\", \"card2\":\"Ah\"},
         {\"name\":\"Frans\", \"stack\":\"6500\", \"position\":\"BB\",\"card1\":\"8c\", \"card2\":\"8d\"},
         {\"name\":\"Dejan\", \"stack\":\"7400\", \"position\":\"BUT\",\"card1\":\"2s\", \"card2\":\"As\"}],
\"streets\":[
        {\"preflop\":[
                 {\"name\":\"Max\", \"action\":\"Post\", \"amount\":\"25\"},
                 {\"name\":\"Frans\", \"action\":\"Post\", \"amount\":\"25\"},
                 {\"name\":\"Dejan\", \"action\":\"Bet\", \"amount\":\"100\"},
                 {\"name\":\"Max\", \"action\":\"Fold\", \"amount\":\"0\"},
                 {\"name\":\"Frans\", \"action\":\"Call\", \"amount\":\"75\"}
        ]},
        {\"flop\":[
              {\"name\":\"Frans\", \"action\":\"Check\", \"amount\":\"0\"},
              {\"name\":\"Dejan\", \"action\":\"Bet\", \"amount\":\"150\"},
              {\"name\":\"Frans\", \"action\":\"Call\", \"amount\":\"150\"}
        ]},
        {\"turn\":[
              {\"name\":\"Frans\", \"action\":\"Check\", \"amount\":\"0\"},
              {\"name\":\"Dejan\", \"action\":\"Bet\", \"amount\":\"400\"},
              {\"name\":\"Frans\", \"action\":\"Call\", \"amount\":\"400\"}
        ]},
        {\"river\":[
              {\"name\":\"Frans\", \"action\":\"Check\", \"amount\":\"0\"},
              {\"name\":\"Dejan\", \"action\":\"Bet\", \"amount\":\"1000\"},
              {\"name\":\"Frans\", \"action\":\"Call\", \"amount\":\"1000\"}
        ]}],
\"communityCards\":[
                {\"card\":\"9s\"},
                {\"card\":\"8s\"},
                {\"card\":\"4c\"},
                {\"card\":\"Qd\"},
                {\"card\":\"3s\"}
]}"

#echo $JSON_DATA
curl -X POST --data "$JSON_DATA" http://localhost:8080/players
