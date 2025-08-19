import { Component } from '@angular/core';
// import { bootstrapApplication } from '@angular/platform-browser';


@Component({
    selector: 'app-root',
    standalone: true,
    template: `
    <h1>Welcome {{ name }}! </h1>
    <h2>Begin your "To Do List" Below</h2>
  `,
})
export class App {
    name = 'Tyerone';
}


//bootstrapApplication(App);
