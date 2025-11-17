import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-property-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <section>
      <h2>Property Listings</h2>
      <p>Sample properties (placeholder data):</p>
      <ul>
        <li *ngFor="let p of properties">
          <strong>{{p.title}}</strong> — {{p.city}}
          <a [routerLink]="['/properties', p.id]">details</a>
        </li>
      </ul>
    </section>
  `
})
export class PropertyListComponent {
  properties = [
    { id: 1, title: '3BR Townhouse', city: 'Pune' },
    { id: 2, title: '2BHK Flat', city: 'Mumbai' },
    { id: 3, title: 'Retail Shop', city: 'Nagpur' }
  ];
}
