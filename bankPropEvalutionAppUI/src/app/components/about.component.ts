import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section>
      <h2>About</h2>
      <p>Bank Property Evaluation — internal tool for evaluating collateral and properties.</p>
    </section>
  `
})
export class AboutComponent {}
