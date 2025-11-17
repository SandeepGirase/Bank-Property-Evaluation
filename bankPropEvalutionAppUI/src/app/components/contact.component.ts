import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section>
      <h2>Contact</h2>
      <p>For issues or questions, contact the team (placeholder).</p>
    </section>
  `
})
export class ContactComponent {}
