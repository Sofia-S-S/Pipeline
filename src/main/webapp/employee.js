function grabAllCards(){
    //select div where we want to place our data from json
    let div = document.getElementById('placeHere')

    //I want to place cards inside of this div. BUT I need to get the cards first. I have already set up an endpoint which I can use to access information about monster cards, so I can use this endpoint to grab my monster cards. We'll need AJAX to accomplish this task.

    //Let's start by creating an XMLHttpRequest object:

    let xhr = new XMLHttpRequest() //readyState 0

    //We need to define what we want to do when the readyState is 4 (meaning that the response body has been populated on the server side); in our case, we want to put some cards on the page for the user to see. We can use the onreadystatechange event listener to listen for changes to our readyState. In essence, this listener is invoked each time the readyState changes.

    xhr.onreadystatechange = function(){
        //You decide what to do each time the readyState changes in this function! Be sure to check that the readyState is 4 and and that the response code is 200 (meaning that everything went smoothly)

        if(xhr.readyState === 4 & xhr.status === 200){
            //JSON.parse is a convenience function for parsing JSON as a JavaScript object
            let card = JSON.parse(xhr.response)
            console.log('the ready state was 4 and the status was 200')

            //We will add all our new cards as divs, so let's create a new div for each
           
                let newCard = document.createElement('div')
                let cardId = document.createElement('p')
                let cardName = document.createElement('p')

                //New let's fill out our card details
                cardId.innerText = card.id 
                cardName.innerText = card.firstName 

                //Now that we've filled out the inner contents of our card data, we can append those elements to our "newCard" div.
                newCard.append(cardId)
                newCard.append(cardName)

                //Finally, we can add this card to the container div we selected earlier.
                div.append(newCard)
            }
        
    }

    //Open my XMLHttpRequest, specifying my HTTP verb and the endpoint I would like to hit.

    xhr.open('GET', 'http://localhost:8080/FreeTuition/EmployeeLoginServlet') //readyState 1
    xhr.send() //readyState 2
}

//Because we want these cards to appear as soon as the web page loads, we can take advantage of the window's onload event listener which fires immediately after the browser loads the window
window.onload = () => {
    grabAllCards()
}