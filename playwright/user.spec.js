const { test, expect } = require('@playwright/test');

test('UI test users page', async ({ page }) => {
    await page.goto('http://localhost:8080/users');
    const content = await page.textContent('body');
    expect(content).toContain('Alice');
});