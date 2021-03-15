# Leaderboard-app
A leaderboard designed for a user to track and manage a team’s 5-a-side football results over multiple seasons.

## Brief
The leaderboard web app would provide an extra layer of competition to friendly 5-a-side games, allowing players to show off their individual record.
5-a-side teams change every game and can be annoying to pick. The app would randomly generate two teams before the next upcoming game.
The team would upload match scores with each player getting points for winning the match. Over the course of a predefined season length, players can see their individual points tally.

### MVP

- A user must be able to add 10 players to the roster, and define the number of matches to be played in a season
- The roster should generate two teams of 5
- The app should allow match scores to be added with the teams and results stored to be viewed later
- Players’ scores should be tallied and shown in a leaderboard

### Extensions
- Be able to have multiple team sizes
- Be able to create more than 2 teams 
- Each player should be able to log in and view the leaderboard for their roster
- Users should be able to update their details

### Further Extensions
- The app should have a stats page to be able to track more detailed information such as goals scored, conceded
- Players should be awarded badges to count season wins, and/or have a crown next to their name to show their leader status
- Add a ‘person of the match’ award which is voted on by the players
- Players should be able to join multiple rosters
- Add sweepstake functionality with the winner of the season taking the whole pot

## How to run
#### Installations
The web app has a Java Spring backend, a React frontent, and uses PostgreSQL for the database.

#### Database
To create a database with PostgreSQL, execute the following in the command line:
  `createdb leaderboard_app`. 
  
#### Backend
Within the backend directory, compile and run the "LeaderboardAppApplication.java" file.  
If you would like to start with an empty database, remove the contents of "DataLoader.java".  
The backend API runs on http://localhost:8080/api. 

#### Frontend
From the frontend directory, install the npm dependencies. 
  `npm install`. 

To start the front end, execute. 
  `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

## Development Team
Stanley Houcke (https://github.com/Stanhoucke). 
Simon Charters (https://github.com/Simon2591990). 
Maciej 'Max' Doroszkiewicz (https://github.com/portypy). 
