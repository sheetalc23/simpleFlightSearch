import { Component } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'United';

  //radio button to show search by flight number or city
  selectedLink = 'Flight';
  
  setRadio(e: string): void {
    this.selectedLink = e;  
  }  

  isSelected(name: string): boolean {  
    if (!this.selectedLink) { // if no radio button is selected, always return false so every nothing is shown  
        return false;  
    }    
    return (this.selectedLink === name); // if current radio button is selected, return true, else return false  
  }    
  
  // Object to save the response returned from the service.
  myresponse: any;

  // Url to fetch the flight results from the spring-mvc application.
  readonly APP_URL = 'http://localhost:8080/simpleFlightSearch';
  
  model: any = {};

  onSubmit() {
    //getFlights(form);
  }

  constructor(private _http: HttpClient) { }

  // Method to fetch all flights based on search params.
  getFlights(form) {
  	const params = new HttpParams()
  	.set('fNum', form.fNum)
  	.set('ori', form.ori)
  	.set('dest', form.dest)
  	.set('date', form.date);
    console.log(form);
    console.log(params);
    
    
    this._http.get((this.APP_URL + '/flights/'), { params }).subscribe(
      data => {
        this.myresponse = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

}
