type Menu = {
    title?: string;
    icon?: string;
    link?: string | [string, string];
    children?: Menu[];
    home?: boolean;
    hidden?: boolean;
}

export const MENU: Menu[] = [
    {
        title: 'Home',
        icon: 'home',
        link: ['/', '/home'],
        home: true,
        hidden: false
    },
];