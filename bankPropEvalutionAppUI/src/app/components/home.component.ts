import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <section>
      <h2>Welcome to Bank Property Evaluation</h2>
      <p>This portal helps bank users evaluate and review properties.</p>
      <p>
        <a routerLink="/properties">Browse properties</a> ·
        <a routerLink="/evaluate">Start an evaluation</a>
      </p>
    </section>
  `
})
export class HomeComponent {}
