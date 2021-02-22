function getInfo(){
 
    //Start by creating an XMLHttpRequest object:

    let xhr = new XMLHttpRequest() //readyState 0

    //We need to define what we want to do when the readyState is 4 (meaning that the response body has been populated on the server side); 
    //in our case, we want to put info on the page for the user to see. We can use the onreadystatechange event listener to listen for changes to our readyState. In essence, this listener is invoked each time the readyState changes.

    xhr.onreadystatechange = function(){
        //You decide what to do each time the readyState changes in this function! Be sure to check that the readyState is 4 and and that the response code is 200 (meaning that everything went smoothly)

        if(xhr.readyState === 4 & xhr.status === 200){
            //JSON.parse is a convenience function for parsing JSON as a JavaScript object
            let employee = JSON.parse(xhr.response)
            console.log('the ready state was 4 and the status was 200')
            console.log(employee)
            let emptyDiv = document.getElementById('emptyDiv')

           
            //Create new input for each field
            //Get value from object we got from JSON
            //Append our new input to empty div
            
                let firstName = document.createElement('input')
                firstName.name = "firstName";
                firstName.type = "text"
                firstName.value = employee.firstName;
                firstName.placeholder = employee.firstName;

                emptyDiv.append(firstName);

                let lastName = document.createElement('input')
                lastName.type = "text"
                lastName.value = employee.lastName;
                emptyDiv.append(lastName)

                let company = document.createElement('input')
                company.type = "text"
                company.value = employee.company;
                emptyDiv.append(company)

                let position = document.createElement('input')
                position.type = "text"
                position.value = employee.position;
                emptyDiv.append(position)

                let email = document.createElement('input')
                email.type = "text"
                email.value = employee.email;
                emptyDiv.append(email)

                let contact = document.createElement('input')
                contact.type = "text"
                contact.value = employee.contact;
                emptyDiv.append(contact)

                let address = document.createElement('input')
                address.type = "text"
                address.value = employee.address;
                emptyDiv.append(address)
             
            
        }
    }

    //Open my XMLHttpRequest, specifying my HTTP verb and the endpoint I would like to hit.

    xhr.open('GET', 'http://localhost:8080/FreeTuition/GetMyInfoServlet') //readyState 1
    xhr.send() //readyState 2
}
 
 function updateInfo(e){
    //Stop page from refreshing
     e.preventDefault()
    //We need to grab the element whose value we're trying to get

    // console.log(document.querySelectorAll("input[value=firstName]"));

     let inputs = document.getElementsByTagName('input')
     console.log(inputs)

    let firstName = inputs[0].value
    console.log(firstName)   

    let lastName = inputs[1].value
    console.log(lastName) 

    let company = inputs[2].value
    console.log(company) 

    let position = inputs[3].value
    console.log(position) 

    let email = inputs[4].value
    console.log(email) 

    let contact = inputs[5].value
    console.log(contact) 

    let address = inputs[6].value
    console.log(address) 



// create a JSON object
const json = {
    "firstName": inputs[0].value
};

// create new request
const xhr = new XMLHttpRequest();

// open request
xhr.open('POST', 'http://localhost:8080/FreeTuition/update-info');

// set `Content-Type` header
xhr.setRequestHeader('Content-Type', 'application/json');

// send rquest with JSON payload
xhr.send(JSON.stringify(json));

console.log(JSON)
console.log(json)

 }



//Info will appear as soon as the web page loads. 
//Use window's onload event listener which fires immediately after the browser loads the window
window.onload = () => {
    getInfo()
}

//add listener to save updates button
let save = document.getElementById('save')
save.addEventListener('click', updateInfo)

