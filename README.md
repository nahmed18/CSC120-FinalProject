# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
  
## Design Justification 
We considered having an alternative way to win the game which was through checking out 10 happy guests and making enough money to build a cafe, library, and pool. However, we realized due to limited time to work on this project and the complexity of the win condition, it would be best to simplify the win condition to be successfully checking-out 10 guests (regardless of satisfaction level) and not failing three hotel-room related tasks as the hotel manager. This way the player's objective is still to be a successful host and reduces the amount of other classes we needed to code and connect to each other.

## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
Our approach was to build a story-driven, modular hotel simulation game using Java’s object-oriented features. Before we started brainstorming, we had a lot of conversations about games we have played in the past such as "Cooking Fever" and "Diner Dash". Taking inspiration from these games, we established our game based off of similar ideas. 
We began by identifying the key entities—Guests, Rooms, HotelBuilding, Player, and Tasks—and modeled them as classes. From there, we created realistic guest profiles with rich backstories to bring humor and tension into the game. Our main game loop focuses on guest arrivals, room assignments, task mini-games, and dynamic checkouts to create an engaging management experience.

- What **new thing(s)** did you learn / figure out in completing this project?
There was a few new things we have learned during our coding process:
    - Learned how to make counters
    - Learned how to implement text-based mini-games 

 - Is there anything that you wish you had **implemented differently**?
Yes. One thing we wish we had done differently was managing guest satisfaction and loyalty over time. We also wish some of our mini-games were timed. But due to scheduling and not having as much to implement everything we wanted into our game, it was hard to implement those details. Otherwsie, we're extremely proud of our work especially with the given time.

 - If you had **unlimited time**, what additional features would you implement?
We would...
    - Add a calendar/day system, where guests book for multiple nights and time progresses.
    - Introduce a review or reputation system such as Google reviews, where guest satisfaction influences the hotel’s popularity and income. That would help unlock getting celebrity guests.
    - Create a staff management system where the player hires and manages workers (e.g., front desk, housekeeping).
    - Add extra floors to unlock such as a library, cafe, and a pool
    - Introduce guest preferences and dynamic events, like surprise visits from family, pet escapes, or romantic drama that changes guest needs mid-stay.

- What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
During demo-day, we were able to present our project to our Professors and got some great feedback! The positivity from both Professors was extremely helpful as it gave us a sense of encouragement to continue with our work. Professor Mosca also gave us additional feedback regarding tweaks that could be made such as making sure if a guest can't be assigned to a room, you can request them to leave which helped us from preventing an infinite loop if the user happens to make an error when assigning a guest.

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
We would tell ourselves to not underestimate the value of playtesting. The more we played our game, the more fun ideas we got along the way. Playing the game was great for visualizing and implementing new ideas and concepts to help give the game a fresh and fun feel!

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
 Working as a team helped us divide responsibilities efficiently. Shahrin focused on guest storytelling and the tasks class as well as mini-games, Nazifa worked on the Game Loop and room classes, and Caitlyn helped with debugging issues, completed the cheatsheet, and added Javadoc comments to help us keep our work organized. We constantly bounced ideas off each other, which made the game funnier, more creative, and way more playable. Our different strengths really complemented each other. Good communication and spontaneous testing sessions made the project fun and collaborative.


